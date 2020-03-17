/*     */ package uk.chromis.custom.controls;
/*     */ 
/*     */

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
/*     */ public class LabeledPasswordField
/*     */   extends HBox
/*     */ {
/*     */   @FXML
/*     */   private HBox panel;
/*     */   @FXML
/*     */   private Label label;
/*     */   @FXML
/*     */   private PasswordField passwordField;
/*  32 */   public BooleanProperty dirty = new SimpleBooleanProperty(false);
/*     */ 
/*     */   
/*     */   public LabeledPasswordField() {
/*  36 */     FXMLLoader loader = new FXMLLoader(getClass().getResource("LabeledPasswordField.fxml"));
/*  37 */     loader.setRoot(this);
/*  38 */     loader.setController(this);
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  43 */       loader.load();
/*  44 */       init();
/*  45 */     } catch (IOException ex) {
/*  46 */       Logger.getLogger(LabeledPasswordField.class.getName())
/*  47 */         .log(Level.SEVERE, null, ex);
/*  48 */       throw new RuntimeException(ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*  53 */   private void init() { this.passwordField.textProperty().addListener((options, oldValue, newValue) -> this.dirty.setValue(Boolean.valueOf(true))); }
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
/*  77 */   public String getPassword() { return this.passwordField.getText(); }
/*     */ 
/*     */   
/*     */   public void setPassword(String text) {
/*  81 */     this.passwordField.setText(text);
/*  82 */     this.dirty.setValue(Boolean.valueOf(false));
/*     */   }
/*     */ 
/*     */   
/*     */   public void setWidthSizes(Double labelWidth, Double passwordWidth) {
/*  87 */     this.label.setPrefWidth(labelWidth.doubleValue());
/*  88 */     this.passwordField.setPrefWidth(passwordWidth.doubleValue());
/*  89 */     setPanel(Double.valueOf(labelWidth.doubleValue() + passwordWidth.doubleValue() + 10.0D));
/*     */   }
/*     */ 
/*     */   
/*  93 */   public void setPanel(Double size) { this.panel.setPrefWidth(size.doubleValue()); }
/*     */ 
/*     */   
/*     */   public void setHeightSizes(Double labelHeight, Double passwordHeight) {
/*  97 */     this.label.setPrefHeight(labelHeight.doubleValue());
/*  98 */     this.passwordField.setPrefHeight(passwordHeight.doubleValue());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 103 */   public void setTextWidth(double width) { this.passwordField.setPrefWidth(width); }
/*     */ 
/*     */ 
/*     */   
/* 107 */   public void setTextHeight(double height) { this.passwordField.setPrefHeight(height); }
/*     */ }
