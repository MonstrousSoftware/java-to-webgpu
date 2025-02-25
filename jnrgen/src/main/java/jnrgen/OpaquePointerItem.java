package jnrgen;

import java.io.IOException;

public class OpaquePointerItem implements Item {

    private final String newType;
    private final String originalType;

    public OpaquePointerItem(String newType, String originalType) {
        this.newType = newType;
        this.originalType = originalType;
    }

    @Override
    public void save(OutputHandler outputHandler) throws IOException {
    }

    @Override
    public void preSave(OutputHandler outputHandler) {

        outputHandler.registerOpaquePointer(newType);
    }

    @Override
    public String getJavaTypeName() {
        return "@u_int64_t long"; //"Pointer";
    }
}
