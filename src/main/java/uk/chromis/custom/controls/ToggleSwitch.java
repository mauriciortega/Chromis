/*     */ package uk.chromis.custom.controls;
/*     */

import javafx.animation.Animation;
import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Node;
import javafx.scene.control.Labeled;
import javafx.scene.paint.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/*     */ public class ToggleSwitch extends Labeled {
/*  21 */   public BooleanProperty dirty = new SimpleBooleanProperty(false); private boolean animating = false;
/*  22 */   public BooleanProperty switchedOn = new SimpleBooleanProperty(false);
/*  23 */   private final TranslateTransition translateAnimation = new TranslateTransition(Duration.seconds(0.25D));
/*  24 */   private final FillTransition fillAnimation = new FillTransition(Duration.seconds(0.25D));
/*  25 */   private final ParallelTransition animation = new ParallelTransition(new Animation[] { this.translateAnimation, this.fillAnimation });
/*  26 */   private Color colorOn = Color.web("#5fca21");
/*     */   
/*     */   private Rectangle activeBackground;
/*     */   private Rectangle disabledBackground;
/*     */   private Rectangle disabledOnBackground;
/*     */   private Circle trigger;
/*     */   private LinearGradient onColour;
/*     */   private LinearGradient offColour;
/*     */   private RadialGradient gradient1;
/*     */   
/*  36 */   public boolean isSwitchedOn() { return this.switchedOn.getValue().booleanValue(); }
/*     */ 
/*     */   
/*     */   public void setSwitchState(Boolean selected) {
/*  40 */     this.switchedOn.setValue(selected);
/*  41 */     this.dirty.setValue(Boolean.valueOf(false));
/*     */   }
/*     */ 
/*     */   
/*  45 */   public Boolean isDirty() { return this.dirty.getValue(); }
/*     */ 
/*     */ 
/*     */   
/*  49 */   public void setDirty(Boolean value) { this.dirty.setValue(value); }
/*     */ 
/*     */   
/*     */   public void setSwDisable(Boolean value) {
/*  53 */     setDisable(value.booleanValue());
/*  54 */     getChildren().clear();
/*  55 */     if (value.booleanValue()) {
/*  56 */       if (isSwitchedOn()) {
/*  57 */         getChildren().addAll(new Node[] { this.disabledOnBackground, this.trigger });
/*     */       } else {
/*     */         
/*  60 */         getChildren().addAll(new Node[] { this.disabledBackground, this.trigger });
/*     */       } 
/*     */     } else {
/*  63 */       getChildren().addAll(new Node[] { this.activeBackground, this.trigger });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ToggleSwitch() {
/*  71 */     this
/*  72 */       .onColour = new LinearGradient(0.0D, 0.0D, 0.0D, 1.0D, true, CycleMethod.NO_CYCLE, new Stop[] { new Stop(0.0D, Color.web("#00EF0B")), new Stop(1.0D, Color.web("#006700")), new Stop(2.0D, Color.web("#006700")) });
/*     */     
/*  74 */     this
/*  75 */       .offColour = new LinearGradient(0.0D, 0.0D, 0.0D, 1.0D, true, CycleMethod.NO_CYCLE, new Stop[] { new Stop(0.0D, Color.web("#727272")), new Stop(1.0D, Color.web("#d0d0d0")) });
/*     */     
/*  77 */     this
/*     */       
/*  79 */       .gradient1 = new RadialGradient(0.0D, 0.0D, 0.1D, 0.1D, 1.0D, true, CycleMethod.REFLECT, new Stop[] { new Stop(0.0D, Color.web("#bab7b2")), new Stop(1.0D, Color.web("#e5e4e2")) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  85 */     this.activeBackground = new Rectangle(28.0D, 14.0D);
/*  86 */     this.activeBackground.setFill(this.offColour);
/*  87 */     this.activeBackground.setStroke(Color.GREY);
/*  88 */     this.activeBackground.setArcWidth(15.0D);
/*  89 */     this.activeBackground.setArcHeight(15.0D);
/*     */     
/*  91 */     this.disabledBackground = new Rectangle(28.0D, 14.0D);
/*  92 */     this.disabledBackground.setStroke(Color.GREY);
/*  93 */     this.disabledBackground.setArcWidth(15.0D);
/*  94 */     this.disabledBackground.setArcHeight(15.0D);
/*  95 */     this.disabledBackground.setFill(Color.LIGHTGRAY);
/*     */     
/*  97 */     this.disabledOnBackground = new Rectangle(28.0D, 14.0D);
/*  98 */     this.disabledOnBackground.setStroke(Color.GREY);
/*  99 */     this.disabledOnBackground.setArcWidth(15.0D);
/* 100 */     this.disabledOnBackground.setArcHeight(15.0D);
/* 101 */     this.disabledOnBackground.setFill(Color.web("#7cbc7c"));
/*     */ 
/*     */ 
/*     */     
/* 105 */     this.trigger = new Circle(7.0D, 7.0D, 7.0D);
/* 106 */     this.trigger.setFill(this.gradient1);
/* 107 */     this.trigger.setStroke(Color.web("#5c5c5c"));
/*     */     
/* 109 */     this.translateAnimation.setNode(this.trigger);
/* 110 */     this.fillAnimation.setShape(this.activeBackground);
/*     */     
/* 112 */     getChildren().addAll(new Node[] { this.activeBackground, this.trigger });
/* 113 */     this.switchedOn.addListener((obs, oldState, isOn) -> {
/* 114 */           if (this.animating) {
/* 115 */             this.animation.stop();
/*     */           }
/* 117 */           this.animating = true;
/* 118 */           this.translateAnimation.setToX(isOn.booleanValue() ? 14.0D : 1.0D);
/* 119 */           this.fillAnimation.setFromValue(isOn.booleanValue() ? Color.GRAY : this.colorOn);
/* 120 */           this.fillAnimation.setToValue(isOn.booleanValue() ? this.colorOn : Color.GRAY);
/*     */           
/* 122 */           this.animation.setOnFinished(event -> {});
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 130 */           this.animation.play();
/*     */         });
/*     */     
/* 133 */     setOnMouseClicked(event -> {
/* 134 */           if (this.animating) {
/*     */             return;
/*     */           }
/* 137 */           this.dirty.setValue(Boolean.valueOf(true));
/* 138 */           this.switchedOn.set(!isSwitchedOn());
/*     */         });
/*     */   }
/*     */ 
/*     */   
/* 143 */   private void setFill(Color colorOn) { this.colorOn = colorOn; }
/*     */ }


/* Location:              /Users/mauricio/dev/Chromis/lib/ChromisCtrls-v1.1.jar!/uk/chromis/custom/controls/ToggleSwitch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
