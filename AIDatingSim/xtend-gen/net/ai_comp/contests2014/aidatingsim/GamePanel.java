package net.ai_comp.contests2014.aidatingsim;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import org.eclipse.xtext.xbase.lib.Exceptions;
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
    Image _loadImage_1 = this.loadImage("res/chara/\u7ACB\u3061\u7D7501_\u901A\u5E38.png");
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
    super.paintComponent(g);
    final Graphics2D g2d = ((Graphics2D) g);
    g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, 
      RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
    g.drawImage(this.bgImage, 0, 0, null);
    g.drawImage(this.charaImage, 200, 0, null);
    Color _color = new Color(0, 0, 0, 192);
    final Color windowColor = _color;
    g.setColor(windowColor);
    g.fillRect(0, 420, 800, 180);
    g.setColor(Color.WHITE);
    Font _font = new Font("", Font.PLAIN, 28);
    final Font font = _font;
    g.setFont(font);
    int _multiply = (34 * 2);
    int _plus = (420 + _multiply);
    g.drawString("\u30A8\u30C7\u30A3\u30BF\u4F55\u4F7F\u3063\u3066\u308B\uFF1F", 14, _plus);
    int _multiply_1 = (34 * 4);
    int _plus_1 = (420 + _multiply_1);
    g.drawString("\u2192Vim\u3068\u7B54\u3048\u308B", 14, _plus_1);
    int _multiply_2 = (34 * 5);
    int _plus_2 = (420 + _multiply_2);
    g.drawString("\u2192Emacs\u3068\u7B54\u3048\u308B", 14, _plus_2);
    int _plus_3 = (420 + 34);
    g.drawString("\u3010\u5973\u306E\u5B50\u3011", 14, _plus_3);
  }
  
  public void run() {
    boolean _while = true;
    while (_while) {
      {
        this.repaint();
        try {
          Thread.sleep(this.sleepTime);
        } catch (final Throwable _t) {
          if (_t instanceof InterruptedException) {
            final InterruptedException e = (InterruptedException)_t;
            e.printStackTrace();
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
      _while = true;
    }
  }
}
