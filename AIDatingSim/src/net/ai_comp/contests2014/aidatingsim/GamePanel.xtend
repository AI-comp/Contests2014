package net.ai_comp.contests2014.aidatingsim

import javax.swing.JPanel
import javax.swing.ImageIcon
import java.awt.Graphics
import java.awt.Image
import java.awt.Color
import java.awt.Font
import java.awt.Graphics2D
import java.awt.RenderingHints

class GamePanel extends JPanel implements Runnable{
	
	var thread = new Thread(this)
	val sleepTime = 30
	
	Image bgImage
	Image charaImage
	
	new(){
		
		bgImage = loadImage('res/bg/classroom_1.jpg')
		charaImage = loadImage('res/chara/立ち絵01_通常.png')

		thread.start()
		
	}
	
	def private Image loadImage(String fileName){
		val icon = new ImageIcon(getClass().getResource(fileName))
		return icon.getImage
	}
	
	
	override void paintComponent(Graphics g){
		super.paintComponent(g)
		val g2d = g as Graphics2D
		
		g2d.setRenderingHint(RenderingHints::KEY_TEXT_ANTIALIASING,
			RenderingHints::VALUE_TEXT_ANTIALIAS_LCD_HRGB
		);
                       
		g.drawImage(bgImage,0,0,null)
		
		g.drawImage(charaImage, 200, 0, null)
		
		val windowColor = new Color(0,0,0,192)
	    g.setColor(windowColor)
	    
		g.fillRect(0,420,800,180)
		
		g.setColor(Color::WHITE)
		val font = new Font('', Font::PLAIN, 28)
		
		g.setFont(font)

		g.drawString('エディタ何使ってる？',14, 420 + 34 * 2)
		g.drawString('→Vimと答える',14, 420 + 34 * 4)
		g.drawString('→Emacsと答える',14, 420 + 34 * 5)

//		g.drawString('好きなタイプ？うーん…… unsigned charかな',14, 420 + 36 * 2)
		g.drawString('【女の子】',14, 420 + 34)
	}
	
	override run() {
		
		
	while(true){
		
		repaint()
		try {
			Thread::sleep(sleepTime)
		} catch (InterruptedException e){
			e.printStackTrace()
		}
		
		}
	}
	
}