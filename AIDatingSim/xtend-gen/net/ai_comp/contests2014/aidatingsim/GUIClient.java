package net.ai_comp.contests2014.aidatingsim;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import net.ai_comp.contests2014.aidatingsim.GamePanel;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class GUIClient extends JFrame {
  private final int WIDTH = 800;
  
  private final int HEIGHT = 600;
  
  public GUIClient() {
    GamePanel _gamePanel = new GamePanel();
    final Procedure1<GamePanel> _function = new Procedure1<GamePanel>() {
      public void apply(final GamePanel it) {
        Dimension _dimension = new Dimension(GUIClient.this.WIDTH, GUIClient.this.HEIGHT);
        it.setPreferredSize(_dimension);
      }
    };
    final GamePanel panel = ObjectExtensions.<GamePanel>operator_doubleArrow(_gamePanel, _function);
    final Container contentPane = this.getContentPane();
    contentPane.add(panel);
    this.pack();
  }
  
  public static void main(final String[] args) {
    GUIClient _gUIClient = new GUIClient();
    final Procedure1<GUIClient> _function = new Procedure1<GUIClient>() {
      public void apply(final GUIClient it) {
        it.setTitle("AIDatingSim");
        it.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        it.setVisible(true);
      }
    };
    final GUIClient frame = ObjectExtensions.<GUIClient>operator_doubleArrow(_gUIClient, _function);
  }
}
