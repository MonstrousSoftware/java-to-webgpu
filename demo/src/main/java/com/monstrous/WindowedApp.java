package com.monstrous;

import org.lwjgl.Version;
import org.lwjgl.glfw.*;
import org.lwjgl.system.MemoryStack;

import java.nio.IntBuffer;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.system.MemoryUtil.NULL;

// Handles window via LWJGL

public class WindowedApp {

    // The window handle
    private long window;
    private long windowHandle;
    private double currentTime;
    private Application application;
    private int mouseX, mouseY;

    private final GLFWFramebufferSizeCallback resizeCallback = new GLFWFramebufferSizeCallback() {
        @Override
        public void invoke (long windowHandle, int w, int h) {
            application.resize(w, h);
        }
    };


    private final GLFWKeyCallback keyCallback = new GLFWKeyCallback() {
        @Override
        public void invoke(long window, int key, int scancode, int action, int mods) {
            LibGPU.input.processKeyEvent(key, action);
        }
    };

    private final GLFWCharCallback charCallback = new GLFWCharCallback() {
        @Override
        public void invoke(long window, int codepoint) {
            LibGPU.input.processCharEvent(codepoint);
        }
    };

    private final GLFWCursorPosCallback mouseMoveCallback = new GLFWCursorPosCallback() {
        @Override
        public void invoke (long windowHandle, double x, double y) {
            mouseX = (int)x;
            mouseY = (int)y;
            LibGPU.input.processMouseMove(mouseX, mouseY);
        }
    };

    private final GLFWMouseButtonCallback mouseCallback = new GLFWMouseButtonCallback() {
        @Override
        public void invoke(long window, int button, int action, int mods) {
            LibGPU.input.processMouseEvent(mouseX, mouseY, button, action);
        }
    };

    private final GLFWScrollCallback scrollCallback = new GLFWScrollCallback() {
        @Override
        public void invoke (long windowHandle, double x, double y) {
            LibGPU.input.processScroll((float)x, (float)y);
        }
    };

    public void openWindow(Application application, ApplicationConfiguration config){
        this.application = application;

        System.out.println("LWJGL " + Version.getVersion() );

        // Setup an error callback. The default implementation
        // will print the error message in System.err.
        GLFWErrorCallback.createPrint(System.err).set();

        // Initialize GLFW. Most GLFW functions will not work before doing this.
        if ( !glfwInit() )
            throw new IllegalStateException("Unable to initialize GLFW");


        //glfwSetWindowUserPointer(window, this);

        // Configure GLFW
        glfwDefaultWindowHints(); // optional, the current window hints are already the default
        glfwWindowHint(GLFW_VISIBLE, GLFW_TRUE); // the window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        glfwWindowHint(GLFW_CLIENT_API, GLFW_NO_API);       // because we will use webgpu

        // Create the window
        window = glfwCreateWindow(config.width, config.height, config.title, NULL, NULL);

        glfwSetFramebufferSizeCallback(window, resizeCallback);
        glfwSetCursorPosCallback(window, mouseMoveCallback);
        glfwSetScrollCallback(window, scrollCallback);
        glfwSetKeyCallback(window, keyCallback);
        glfwSetCharCallback(window, charCallback);
        glfwSetMouseButtonCallback(window, mouseCallback);



        System.out.println("window from glfwCreateWindow = "+Long.toString(window, 16));
        if ( window == NULL )
            throw new RuntimeException("Failed to create the GLFW window");

        String title = glfwGetWindowTitle(window);
        System.out.println("Window title: " + title);

        windowHandle = GLFWNativeWin32.glfwGetWin32Window(window);
        System.out.println("Window HWND: " + Long.toString(windowHandle, 16));


        // Get the thread stack and push a new frame
        try ( MemoryStack stack = stackPush() ) {
            IntBuffer pWidth = stack.mallocInt(1); // int*
            IntBuffer pHeight = stack.mallocInt(1); // int*

            // Get the window size passed to glfwCreateWindow
            glfwGetWindowSize(window, pWidth, pHeight);

            // Get the resolution of the primary monitor
            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            // Center the window
            glfwSetWindowPos(
                    window,
                    (vidmode.width() - pWidth.get(0)) / 2,
                    (vidmode.height() - pHeight.get(0)) / 2
            );
        } // the stack frame is popped automatically

        // Make the window visible
        //glfwShowWindow(window);
    }

    public long getWindowHandle(){
        return windowHandle;
    }

    public boolean getShouldClose(){
        return glfwWindowShouldClose(window);
    }

    public void setShouldClose(boolean value){
        glfwSetWindowShouldClose(window, value); // We will detect this in the rendering loop
    }

    public void pollEvents() {
        // Poll for window events. The key callback above will only be
        // invoked during this call.
        glfwPollEvents();
    }

    public float getDeltaTime() {
        double prevTime = currentTime;
        currentTime = glfwGetTime();
        return (float)(currentTime - prevTime);
    }

    public void closeWindow(){

        // Free the window callbacks and destroy the window
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);

        // Terminate GLFW and free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();

    }
}
