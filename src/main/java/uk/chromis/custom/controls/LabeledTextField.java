/*     */ package uk.chromis.custom.controls;
/*     */ 
/*     */

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LabeledTextField
/*     */   extends HBox
/*     */ {
/*     */   @FXML
/*     */   private HBox panel;
/*     */   @FXML
/*     */   private Label label;
/*     */   @FXML
/*     */   private TextField textField;
/*  32 */   public BooleanProperty dirty = new SimpleBooleanProperty(false);
/*     */ 
/*     */   
/*     */   public LabeledTextField() {
/*  36 */     FXMLLoader loader = new FXMLLoader(getClass().getResource("LabeledTextField.fxml"));
/*  37 */     loader.setRoot(this);
/*  38 */     loader.setController(this);
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  43 */       loader.load();
/*  44 */       init();
/*  45 */     } catch (IOException ex) {
/*  46 */       Logger.getLogger(LabeledTextField.class.getName())
/*  47 */         .log(Level.SEVERE, null, ex);
/*  48 */       throw new RuntimeException(ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*  53 */   private void init() { this.textField.textProperty().addListener((options, oldValue, newValue) -> this.dirty.setValue(Boolean.valueOf(true))); }
/*     */ 
/*     */ 
/*     */   
/*  57 */   public Boolean isDirty() { return this.dirty.getValue(); }
/*     */ 
/*     */ 
/*     */   
/*  61 */   public void setDirty(Boolean dirty) { this.dirty.setValue(dirty); }
/*     */ 
/*     */ 
/*     */   
/*  65 */   public void setLabel(String text) { this.label.setText(text); }
/*     */ 
/*     */ 
/*     */   
/*  69 */   public void setLabelWidth(double width) { this.label.setPrefWidth(width); }
/*     */ 
/*     */ 
/*     */   
/*  73 */   public void setLabelHeight(double height) { this.label.setPrefHeight(height); }
/*     */ 
/*     */ 
/*     */   
/*  77 */   public void setPanel(Double size) { this.panel.setPrefWidth(size.doubleValue()); }
/*     */ 
/*     */   
/*     */   public void setWidthSizes(Double labelWidth, Double textFieldWidth) {
/*  81 */     this.label.setPrefWidth(labelWidth.doubleValue());
/*  82 */     this.textField.setPrefWidth(textFieldWidth.doubleValue());
/*  83 */     setPanel(Double.valueOf(labelWidth.doubleValue() + textFieldWidth.doubleValue() + 10.0D));
/*     */   }
/*     */   
/*     */   public void setHeightSizes(Double labelHeight, Double textFieldHeight) {
/*  87 */     this.label.setPrefHeight(labelHeight.doubleValue());
/*  88 */     this.textField.setPrefHeight(textFieldHeight.doubleValue());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  93 */   public String getText() { return this.textField.getText(); }
/*     */ 
/*     */   
/*     */   public void setText(String text) {
/*  97 */     this.textField.setText(text);
/*  98 */     this.dirty.setValue(Boolean.valueOf(false));
/*     */   }
/*     */   
/*     */   public void setDisable(Boolean value) {
/* 102 */     this.label.setDisable(value.booleanValue());
/* 103 */     this.textField.setDisable(value.booleanValue());
/*     */   }
/*     */ 
/*     */   
/* 107 */   public void setTextWidth(double width) { this.textField.setPrefWidth(width); }
/*     */ 
/*     */ 
/*     */   
/* 111 */   public void setTextHeight(double height) { this.textField.setPrefHeight(height); }
/*     */ 
/*     */ 
/*     */   
/* 115 */   public TextField getTextField() { return this.textField; }
/*     */ }

