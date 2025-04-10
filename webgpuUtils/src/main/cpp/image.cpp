/*
* Wrapper around stb_image single header library to make a few functions available via JNI.
*/



#include "image.h"

#define STB_IMAGE_IMPLEMENTATION
#include "stb_image.h"

#define STB_IMAGE_WRITE_IMPLEMENTATION
#include "stb_image_write.h"

#ifdef __cplusplus
extern "C" {
#endif

EXPORT gdx2d_pixmap* gdx2d_load(const unsigned char *buffer, uint32_t len) {
	int32_t width, height, format;
	unsigned char* pixels;

    pixels = stbi_load_from_memory(buffer, len, &width, &height, &format, 4);  // force 4 components: RGBA
	if (pixels == NULL){
	    //printf("gdx2d_load: load error\n");
		return NULL;
	}


	gdx2d_pixmap* pixmap = (gdx2d_pixmap*)malloc(sizeof(gdx2d_pixmap));
	if (!pixmap) return 0;
	pixmap->width = (uint32_t)width;
	pixmap->height = (uint32_t)height;
	pixmap->format = (uint32_t)format;          // todo convert, stbi just returns # channels
	pixmap->blend = GDX2D_BLEND_SRC_OVER;
	pixmap->scale = GDX2D_SCALE_BILINEAR;
	pixmap->pixels = pixels;
	//printf("gdx2d_load: w = %d, h = %d, format = %d\n", pixmap->width, pixmap->height, pixmap->format);
	//printf("pixmap at %p\n", pixmap);
	return pixmap;
}

EXPORT void gdx2d_free(const gdx2d_pixmap* pixmap) {
	free((void*)pixmap->pixels);
	free((void*)pixmap);
}


EXPORT int write_png(char const *filename, int w, int h, int numComponents, const void  *data, int stride_in_bytes){
    return stbi_write_png(filename, w, h, numComponents, data, stride_in_bytes);
}


#ifdef __cplusplus
}
#endif


