package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Komento {
    protected TextField tuloskentta;
    protected TextField syotekentta;
    protected Button nollaa;
    protected Button undo;
    protected Sovelluslogiikka sovellus;
    protected int syote;
    protected int tulos;
    protected int alkuperainenTulos;
    protected int alkuperainenSyote;

    public Komento(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
      this.tuloskentta = tuloskentta;
      this.syotekentta = syotekentta;
      this.sovellus = sovellus;
      this.undo = undo;
      this.sovellus = sovellus;
      this.syote = 0;
      this.tulos = 0;
      this.syotekentta.setText("");
      this.tuloskentta.setText("0");
    }

    public void peru() {
      this.syote = this.alkuperainenSyote;
      this.tulos = this.alkuperainenTulos;
      this.setSyote(this.syote);
      this.setTulos(this.tulos);
    };

    protected int getSyote() {
      return Integer.parseInt(this.syotekentta.getText());
    }

    protected int getTulos() {
      return Integer.parseInt(this.tuloskentta.getText());
    }

    protected void setTulos(int uusiTulos) {
      this.tuloskentta.setText(uusiTulos + "");
    }

    protected void setSyote(int uusiSyote) {
      this.tuloskentta.setText(uusiSyote + "");
    }

    protected void nollaaSyote() {
      this.syotekentta.setText("");
    }

    protected void tallennaAlkuperaiset() {
      String syoteString = this.syotekentta.getText();
      if (! syoteString.equals("")) {
        this.alkuperainenSyote = Integer.parseInt(syoteString);
      } else {
        this.alkuperainenSyote = 0;
      }
      this.alkuperainenTulos = Integer.parseInt(this.tuloskentta.getText());
    }

    public abstract void suorita();
    
}
