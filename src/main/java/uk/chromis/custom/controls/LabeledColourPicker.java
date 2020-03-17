/*     */ package uk.chromis.custom.controls;
/*     */ 
/*     */

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

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
/*     */ 
/*     */ 
/*     */ public class LabeledColourPicker
/*     */   extends HBox
/*     */ {
/*     */   @FXML
/*     */   private Label label;
/*     */   @FXML
/*     */   private ColorPicker colourPicker;
/*     */   @FXML
/*     */   private Pane optionsPane;
/*  34 */   public BooleanProperty dirty = new SimpleBooleanProperty(false);
/*     */ 
/*     */   
/*     */   public LabeledColourPicker() {
/*  38 */     FXMLLoader loader = new FXMLLoader(getClass().getResource("LabeledColourPicker.fxml"));
/*  39 */     loader.setRoot(this);
/*  40 */     loader.setController(this);
/*     */     
/*     */     try {
/*  43 */       loader.load();
/*  44 */       init();
/*  45 */     } catch (IOException ex) {
/*  46 */       Logger.getLogger(LabeledColourPicker.class.getName())
/*  47 */         .log(Level.SEVERE, null, ex);
/*  48 */       throw new RuntimeException(ex);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void init() {
/*  53 */     this.colourPicker.setOnAction(new EventHandler<ActionEvent>()
/*     */         {
/*     */           public void handle(ActionEvent event) {
/*  56 */             LabeledColourPicker.this.dirty.setValue(Boolean.valueOf(true));
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*  62 */   public ColorPicker getPicker() { return this.colourPicker; }
/*     */ 
/*     */ 
/*     */   
/*  66 */   public Boolean isDirty() { return this.dirty.getValue(); }
/*     */ 
/*     */ 
/*     */   
/*  70 */   public void setDirty(Boolean dirty) { this.dirty.setValue(dirty); }
/*     */ 
/*     */ 
/*     */   
/*  74 */   public void setText(String str) { this.label.setText(str); }
/*     */ 
/*     */ 
/*     */   
/*  78 */   public void setHeight(Double value) { this.label.setPrefHeight(value.doubleValue()); }
/*     */ 
/*     */ 
/*     */   
/*  82 */   public void setLabelWidth(Double value) { this.label.setPrefWidth(value.doubleValue()); }
/*     */ 
/*     */   
/*     */   public String getColour() {
/*  86 */     return String.format("#%02X%02X%02X", new Object[] {
/*  87 */           Integer.valueOf((int)(this.colourPicker.getValue().getRed() * 255.0D)), 
/*  88 */           Integer.valueOf((int)(this.colourPicker.getValue().getGreen() * 255.0D)), 
/*  89 */           Integer.valueOf((int)(this.colourPicker.getValue().getBlue() * 255.0D))
/*     */         });
/*     */   }
/*     */   
/*  93 */   public void setColour(String colour) { this.colourPicker.setValue(Color.valueOf(colour)); }
/*     */ 
/*     */ 
/*     */   
/*  97 */   public void setColour(Color pColour) { this.colourPicker.setValue(pColour); }
/*     */ 
/*     */   
/*     */   public void setDisable(Boolean value) {
/* 101 */     this.label.setDisable(value.booleanValue());
/* 102 */     this.colourPicker.setDisable(value.booleanValue());
/*     */   }
/*     */ }

