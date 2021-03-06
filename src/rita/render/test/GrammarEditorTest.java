package rita.render.test;

import processing.core.PApplet;
import rita.RiGrammar;
import rita.RiText;

public class GrammarEditorTest extends PApplet {

  RiText[] rts;
  RiGrammar grammar;

  public void setup() 
  {
    size(600, 200);
    rts = new RiText[3];
    
    RiText.defaults.alignment = CENTER;
    RiText.defaultFont("Times", 24);
    rts[0] = new RiText(this, "click to", width / 2, 85);
    rts[1] = new RiText(this, "generate", width / 2, 110);
    rts[2] = new RiText(this, "a haiku", width / 2, 135);
    
    grammar = new RiGrammar();
    grammar.loadFromFile("haikuGrammar2.json");
    grammar.openEditor(width, 600);    
  }
  
  public void mouseClicked() {
    String result = grammar.expand();
    String[] lines = result.split("%");
    for (int i = 0; i < rts.length; i++)
      rts[i].textTo(lines[i].trim(), 1.0f);
  }

  public void draw() {
    background(255);
    RiText.drawAll();
  }
}
