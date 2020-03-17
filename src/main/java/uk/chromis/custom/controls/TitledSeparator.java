/*    */ package uk.chromis.custom.controls;
/*    */ 
/*    */

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TitledSeparator
/*    */   extends HBox
/*    */ {
/*    */   @FXML
/*    */   private Label label;
/*    */   @FXML
/*    */   private Pane trailingPane;
/*    */   @FXML
/*    */   private Pane leadingPane;
/*    */   @FXML
/*    */   private Separator trailingSeparator;
/*    */   @FXML
/*    */   private Separator leadingSeparator;
/*    */   
/*    */   public TitledSeparator() {
/* 36 */     FXMLLoader loader = new FXMLLoader(getClass().getResource("TitledSeparator.fxml"));
/* 37 */     loader.setRoot(this);
/* 38 */     loader.setController(this);
/*    */     
/*    */     try {
/* 41 */       loader.load();
/*    */     }
/* 43 */     catch (IOException ex) {
/* 44 */       Logger.getLogger(DeviceConfig.class.getName())
/* 45 */         .log(Level.SEVERE, null, ex);
/* 46 */       throw new RuntimeException(ex);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void setText(String text) {
/* 51 */     double width = (7 * text.length()) + getCount(text, "w") * 4.0D + getCount(text, "W") * 6.5D;
/* 52 */     width = width + getCount(text, "M") * 6.5D + getCount(text, "m") * 5.0D;
/* 53 */     if (getCount(text, "W") <= 3.0D || getCount(text, "M") <= 3.0D) {
/* 54 */       width += 6.0D;
/*    */     }
/* 56 */     width -= getCount(text, ".") * 4.0D;
/* 57 */     width -= getCount(text, ",") * 4.0D;
/* 58 */     width -= getCount(text, ":") * 4.0D;
/* 59 */     width -= getCount(text, ";") * 4.0D;
/*    */     
/* 61 */     this.label.setPrefWidth(width);
/* 62 */     this.label.setText(text);
/*    */   }
/*    */   
/*    */   public void setLeadingSeparator(Double size) {
/* 66 */     this.leadingPane.setPrefWidth(size.doubleValue());
/* 67 */     this.leadingSeparator.setPrefWidth(size.doubleValue());
/*    */   }
/*    */   
/*    */   public void setWidth(Double size) {
/* 71 */     Double width = Double.valueOf(this.leadingSeparator.getPrefWidth() + this.label.getPrefWidth());
/* 72 */     this.trailingPane.setPrefWidth(size.doubleValue() - width.doubleValue());
/* 73 */     this.trailingSeparator.setPrefWidth(size.doubleValue() - width.doubleValue());
/*    */   }
/*    */ 
/*    */   
/* 77 */   public void setSize(Double width) { this.label.setPrefWidth(width.doubleValue()); }
/*    */ 
/*    */   
/*    */   private double getCount(String str, String c) {
/* 81 */     int count = str.length() - str.replace(c, "").length();
/* 82 */     return count;
/*    */   }
/*    */ }


/* Location:              /Users/mauricio/dev/Chromis/lib/ChromisCtrls-v1.1.jar!/uk/chromis/custom/controls/TitledSeparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
