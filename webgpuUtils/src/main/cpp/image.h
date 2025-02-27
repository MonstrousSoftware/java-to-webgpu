#ifndef __GDX2D__
#define __GDX2D__


#if defined(_WIN32)
#   define EXPORT __declspec(dllexport)
#endif

#include <cstdint>

#ifdef __cplusplus
extern "C" {
#endif

/**
 * pixmap formats, components are laid out in memory
 * in the order they appear in the constant name. E.g.
 * GDX_FORMAT_RGB => pixmap[0] = r, pixmap[1] = g, pixmap[2] = b.
 * Components are 8-bit each except for RGB565 and RGBA4444 which
 * take up two bytes each. The order of bytes is machine dependent
 * within a short the high order byte holds r and the first half of g
 * the low order byte holds the lower half of g and b as well as a
 * if the format is RGBA4444
 */
#define GDX2D_FORMAT_ALPHA 				1
#define GDX2D_FORMAT_LUMINANCE_ALPHA 	2
#define GDX2D_FORMAT_RGB888 			3
#define GDX2D_FORMAT_RGBA8888			4
#define GDX2D_FORMAT_RGB565				5
#define GDX2D_FORMAT_RGBA4444			6

#define GDX2D_FORMAT_HDR			    12  // experimental

/**
 * blending modes, to be extended
 */
#define GDX2D_BLEND_NONE 		0
#define GDX2D_BLEND_SRC_OVER 	1

/**
 * scaling modes, to be extended
 */
#define GDX2D_SCALE_NEAREST		0
#define GDX2D_SCALE_BILINEAR	1

/**
 * simple pixmap struct holding the pixel data,
 * the dimensions and the format of the pixmap.
 * the format is one of the GDX2D_FORMAT_XXX constants.
 */
typedef struct {
	uint32_t width;
	uint32_t height;
	uint32_t format;
	uint32_t blend;
	uint32_t scale;
	const unsigned char* pixels;
} gdx2d_pixmap;



EXPORT gdx2d_pixmap* gdx2d_load (const unsigned char *buffer, uint32_t len);
EXPORT void 		 gdx2d_free (const gdx2d_pixmap* pixmap);


#ifdef __cplusplus
}
#endif

#endif
