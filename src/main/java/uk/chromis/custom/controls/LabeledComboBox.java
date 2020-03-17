/*     */ package uk.chromis.custom.controls;
/*     */ 
/*     */

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LabeledComboBox
/*     */   extends HBox
/*     */ {
/*     */   @FXML
/*     */   private HBox panel;
/*     */   @FXML
/*     */   private Label label;
/*     */   @FXML
/*     */   private ComboBox comboBox;
/*  38 */   public BooleanProperty dirty = new SimpleBooleanProperty(false);
/*     */   
/*     */   public LabeledComboBox() {
/*  41 */     FXMLLoader loader = new FXMLLoader(getClass().getResource("LabeledComboBox.fxml"));
/*  42 */     loader.setRoot(this);
/*  43 */     loader.setController(this);
/*     */     
/*     */     try {
/*  46 */       loader.load();
/*  47 */       init();
/*  48 */     } catch (IOException ex) {
/*  49 */       Logger.getLogger(LabeledComboBox.class.getName()).log(Level.SEVERE, null, ex);
/*  50 */       throw new RuntimeException(ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*  55 */   private void init() { this.comboBox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> this.dirty.setValue(Boolean.valueOf(true))); }
/*     */ 
/*     */ 
/*     */   
/*  59 */   public Boolean isDirty() { return this.dirty.getValue(); }
/*     */ 
/*     */ 
/*     */   
/*  63 */   public void setDirty(Boolean dirty) { this.dirty.setValue(dirty); }
/*     */ 
/*     */ 
/*     */   
/*  67 */   public void setLabel(String str) { this.label.setText(str); }
/*     */ 
/*     */   
/*     */   public void setItemHeight(String name, Double value) {
/*  71 */     switch (name) {
/*     */       case "label":
/*  73 */         this.label.setPrefHeight(value.doubleValue());
/*     */         break;
/*     */       case "comboBox":
/*  76 */         this.comboBox.setPrefHeight(value.doubleValue());
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addItemList(ObservableList listItems) {
/*  82 */     this.comboBox.setItems(listItems);
/*  83 */     this.comboBox.getSelectionModel().selectFirst();
/*  84 */     this.dirty.setValue(Boolean.valueOf(false));
/*     */   }
/*     */   
/*     */   public void setItemWidth(String name, Double value) {
/*  88 */     switch (name) {
/*     */       case "label":
/*  90 */         this.label.setPrefWidth(value.doubleValue());
/*     */         break;
/*     */       case "comboBox":
/*  93 */         this.comboBox.setPrefWidth(value.doubleValue());
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*  99 */   public void setPanel(Double size) { this.panel.setPrefWidth(size.doubleValue()); }
/*     */ 
/*     */ 
/*     */   
/* 103 */   public ComboBox getComboBox() { return this.comboBox; }
/*     */ 
/*     */   
/*     */   public void setWidthSizes(Double labelWidth, Double comboWidth) {
/* 107 */     this.label.setPrefWidth(labelWidth.doubleValue());
/* 108 */     this.comboBox.setPrefWidth(comboWidth.doubleValue());
/* 109 */     setPanel(Double.valueOf(labelWidth.doubleValue() + comboWidth.doubleValue() + 10.0D));
/*     */   }
/*     */   
/*     */   public void setHeightSizes(Double labelHeight, Double comboHeight) {
/* 113 */     this.label.setPrefHeight(labelHeight.doubleValue());
/* 114 */     this.comboBox.setPrefHeight(comboHeight.doubleValue());
/*     */   }
/*     */ 
/*     */   
/* 118 */   public void select(int index) { this.comboBox.getSelectionModel().select(index); }
/*     */ 
/*     */ 
/*     */   
/* 122 */   public int getSize() { return this.comboBox.getItems().size(); }
/*     */ 
/*     */ 
/*     */   
/* 126 */   public Object getItem(int index) { return this.comboBox.getItems().get(index); }
/*     */ 
/*     */   
/*     */   public void setDisable(Boolean value) {
/* 130 */     this.label.setDisable(value.booleanValue());
/* 131 */     this.comboBox.setDisable(value.booleanValue());
/*     */   }
/*     */ 
/*     */   
/* 135 */   public void setSelected(String str) { this.comboBox.getSelectionModel().select(str); }
/*     */ 
/*     */ 
/*     */   
/* 139 */   public Object getSelected() { return this.comboBox.getSelectionModel().getSelectedItem(); }
/*     */ }
