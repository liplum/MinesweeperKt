package net.liplum

import com.soywiz.klock.*
import com.soywiz.korge.*
import com.soywiz.korge.scene.*
import com.soywiz.korge.tween.*
import com.soywiz.korge.view.*
import com.soywiz.korge.view.roundRect
import com.soywiz.korim.color.*
import com.soywiz.korim.format.*
import com.soywiz.korio.file.std.*
import com.soywiz.korma.geom.*
import com.soywiz.korma.geom.vector.*
import com.soywiz.korma.interpolation.*

var tileSize = 0.0
var blockCountPerSide = 8

suspend fun main() =
  Korge(
    title = "Minesweeper",
    width = 512,
    height = 512,
    virtualWidth = 512,
    virtualHeight = 512,
    bgcolor = Colors["#cec0b2"],
    gameId = "net.liplum.MinesweeperKt"
  ) {
    val sceneContainer = sceneContainer()

    sceneContainer.changeTo({ MyScene() })
  }

class MyScene : Scene() {
  override suspend fun SContainer.sceneMain() {
    tileSize = views.virtualWidth / blockCountPerSide.toDouble()
    val tilesImg = resourcesVfs["tiles.png"].readBitmap().toSpriteVariants(5)
    graphics {
      it.position(0.0, 0.0)
      fill(Colors["#cec0b2"]) {
        for (i in 0..blockCountPerSide) {
          for (j in 0..blockCountPerSide) {
            Image(tilesImg.random(), smoothing = false).apply {
              scaledWidth = tileSize
              scaledHeight = tileSize
              position(tileSize * i, tileSize * j)
            }.addTo(it)
          }
        }
      }
    }
  }
}
