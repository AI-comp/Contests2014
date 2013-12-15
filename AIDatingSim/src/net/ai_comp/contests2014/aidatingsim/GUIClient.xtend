package net.ai_comp.contests2014.aidatingsim

import javax.swing.JFrame
import java.awt.Dimension

class GUIClient extends JFrame{
	
	val WIDTH  = 800
	val HEIGHT = 600
	
	new() {
		val panel = new GamePanel => [
			setPreferredSize(new Dimension(WIDTH, HEIGHT))
		]
		val contentPane = getContentPane
		
		contentPane.add(panel)
		pack
	}
	
	def static void main(String[] args){
		val frame = new GUIClient => [
			title = 'AIDatingSim'
			defaultCloseOperation = JFrame::EXIT_ON_CLOSE
			visible = true
		]	

	}
	
}