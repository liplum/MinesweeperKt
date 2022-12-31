package net.liplum

import com.soywiz.korim.bitmap.*

fun <T> T.toSpriteVariants(
  variant: Int,
  horizontal: Boolean = true,
): List<BitmapSlice<T>> where T : Bitmap {
  val res = mutableListOf<BitmapSlice<T>>();
  if (horizontal) {
    val perWidth = width / variant
    for (i in 0 until variant) {
      res.add(sliceWithSize(perWidth * i, 0, perWidth, height))
    }
  } else {
    val perHeight = height / variant
    for (i in 0 until variant) {
      res.add(sliceWithSize(0, perHeight * i, width, perHeight))
    }
  }
  return res
}
