/*     */ package uk.chromis.custom.controls;
/*     */ 
/*     */

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LabeledToggleSwitch
/*     */   extends Pane
/*     */ {
/*  41 */   public BooleanProperty dirty = new SimpleBooleanProperty(false);
/*  42 */   public BooleanProperty switchedOn = new SimpleBooleanProperty(false);
/*     */   
/*     */   private final HBox hBox;
/*     */   private final ToggleSwitch toggleSw;
/*     */   private final Label lbl;
/*     */   private final Pane togglePane;
/*     */   public static final int LEFT = 0;
/*     */   public static final int RIGHT = 1;
/*     */   
/*     */   public LabeledToggleSwitch() {
/*  52 */     this.hBox = new HBox();
/*  53 */     this.hBox.maxHeight(28.0D);
/*  54 */     this.hBox.prefHeight(28.0D);
/*  55 */     this.hBox.setAlignment(Pos.CENTER);
/*  56 */     this.hBox.setPadding(new Insets(0.0D, 8.0D, 0.0D, 0.0D));
/*     */ 
/*     */     
/*  59 */     this.lbl = new Label("Label");
/*  60 */     this.lbl.setPrefHeight(18.0D);
/*  61 */     this.lbl.setPrefWidth(100.0D);
/*  62 */     this.lbl.setPadding(new Insets(0.0D, 15.0D, 0.0D, 2.0D));
/*     */ 
/*     */     
/*  65 */     this.toggleSw = new ToggleSwitch();
/*  66 */     this.togglePane = new Pane();
/*  67 */     this.togglePane.setPrefWidth(40.0D);
/*  68 */     this.togglePane.setPadding(new Insets(8.0D, 8.0D, 8.0D, 20.0D));
/*  69 */     this.toggleSw.setLayoutY(3.0D);
/*  70 */     this.toggleSw.setLayoutX(5.0D);
/*  71 */     this.togglePane.getChildren().add(this.toggleSw);
/*     */     
/*  73 */     this.switchedOn.bindBidirectional(this.toggleSw.switchedOn);
/*  74 */     this.dirty.bindBidirectional(this.toggleSw.dirty);
/*     */     
/*  76 */     this.hBox.getChildren().addAll(new Node[] { this.lbl, this.togglePane });
/*  77 */     getChildren().add(this.hBox);
/*     */   }
/*     */ 
/*     */   
/*  81 */   public void setSelected(Boolean selected) { this.toggleSw.setSwitchState(selected); }
/*     */ 
/*     */ 
/*     */   
/*  85 */   public Boolean isSelected() { return Boolean.valueOf(this.toggleSw.isSwitchedOn()); }
/*     */ 
/*     */ 
/*     */   
/*  89 */   public Boolean isDirty() { return this.toggleSw.isDirty(); }
/*     */ 
/*     */ 
/*     */   
/*  93 */   public void setDirty(Boolean value) { this.toggleSw.setDirty(value); }
/*     */ 
/*     */   
/*     */   public void setSwitchDisable(Boolean value) {
/*  97 */     this.lbl.setDisable(value.booleanValue());
/*  98 */     this.toggleSw.setSwDisable(value);
/*     */   }
/*     */   
/*     */   public void setSwPosition(int value) {
/* 102 */     if (value == 0) {
/* 103 */       this.hBox.getChildren().clear();
/* 104 */       this.hBox.getChildren().addAll(new Node[] { this.togglePane, this.lbl });
/*     */     } else {
/* 106 */       this.hBox.getChildren().clear();
/* 107 */       this.hBox.getChildren().addAll(new Node[] { this.lbl, this.togglePane });
/*     */     } 
/* 109 */     getChildren().clear();
/* 110 */     getChildren().add(this.hBox);
/*     */   }
/*     */ 
/*     */   
/* 114 */   public void setLabelWidth(Double width) { this.lbl.setPrefWidth(width.doubleValue()); }
/*     */ 
/*     */ 
/*     */   
/* 118 */   public void setText(String text) { this.lbl.setText(text); }
/*     */ 
/*     */ 
/*     */   
/*     */   public void labelSetBold() {
/* 123 */     Font font = this.lbl.getFont();
/* 124 */     Double size = Double.valueOf(font.getSize());
/* 125 */     this.lbl.setFont(Font.font(font.getName(), FontWeight.BOLD, size.doubleValue()));
/*     */   }
/*     */ }

