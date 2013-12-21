package net.ai_comp.contests2014.aidatingsim;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class GamePanel extends JPanel implements Runnable {
  private Thread thread = new Function0<Thread>() {
    public Thread apply() {
      Thread _thread = new Thread(GamePanel.this);
      return _thread;
    }
  }.apply();
  
  private final int sleepTime = 30;
  
  private Image bgImage;
  
  private Image charaImage;
  
  public GamePanel() {
    Image _loadImage = this.loadImage("res/bg/classroom_1.jpg");
    this.bgImage = _loadImage;
    Image _loadImage_1 = this.loadImage("res/chara/立ち絵01_通常.png");
    this.charaImage = _loadImage_1;
    this.thread.start();
  }
  
  private Image loadImage(final String fileName) {
    Class<? extends GamePanel> _class = this.getClass();
    URL _resource = _class.getResource(fileName);
    ImageIcon _imageIcon = new ImageIcon(_resource);
    final ImageIcon icon = _imageIcon;
    return icon.getImage();
  }
  
  public void paintComponent(final Graphics g) {
    throw new Error("Unresolved compilation problems:"
      + "\nmissing \')\' at \'→Vimと答�\'"
      + "\nno viable alternative at input \'\ufffd\'"
      + "\nmismatched input \',\' expecting \'}\'"
      + "\nInvalid number of arguments. The method drawString(String, int, int) is not applicable for the arguments (String)"
      + "\nThis expression is not allowed in this context, since it doesn\'t cause any side effects.");
  }
  
  private Object 好き�;
}
