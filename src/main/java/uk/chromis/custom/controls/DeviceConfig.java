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
import javafx.scene.layout.Pane;
import uk.chromis.custom.utils.StringParser;

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
/*     */ public class DeviceConfig
/*     */   extends HBox
/*     */ {
/*     */   @FXML
/*     */   private Label deviceLabel;
/*     */   @FXML
/*     */   private Label portLabel;
/*     */   @FXML
/*     */   private ComboBox deviceCBox;
/*     */   @FXML
/*     */   private ComboBox portCBox;
/*     */   @FXML
/*     */   private Pane optionsPane;
/*  37 */   public BooleanProperty dirty = new SimpleBooleanProperty(false);
/*     */ 
/*     */   
/*     */   public DeviceConfig() {
/*  41 */     FXMLLoader loader = new FXMLLoader(getClass().getResource("DeviceConfig.fxml"));
/*  42 */     loader.setRoot(this);
/*  43 */     loader.setController(this);
/*     */     
/*     */     try {
/*  46 */       loader.load();
/*  47 */       init();
/*  48 */     } catch (IOException ex) {
/*  49 */       Logger.getLogger(DeviceConfig.class.getName())
/*  50 */         .log(Level.SEVERE, null, ex);
/*  51 */       throw new RuntimeException(ex);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void init() {
/*  56 */     this.deviceCBox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
/*  57 */           this.dirty.setValue(Boolean.valueOf(true));
/*  58 */           switch (this.deviceCBox.getSelectionModel().getSelectedItem().toString().toLowerCase()) {
/*     */             case "not defined":
/*     */             case "screen":
/*  61 */               displayConfigs(Boolean.valueOf(false));
/*     */               return;
/*     */           } 
/*  64 */           displayConfigs(Boolean.valueOf(true));
/*  65 */           if (this.portCBox.getSelectionModel().getSelectedItem() == null) {
/*  66 */             this.portCBox.getSelectionModel().selectFirst();
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  71 */     this.portCBox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> this.dirty.setValue(Boolean.valueOf(true)));
/*     */   }
/*     */ 
/*     */   
/*  75 */   public Boolean isDirty() { return this.dirty.getValue(); }
/*     */ 
/*     */ 
/*     */   
/*  79 */   public void setDirty(Boolean dirty) { this.dirty.setValue(dirty); }
/*     */ 
/*     */ 
/*     */   
/*  83 */   public ComboBox getDevice() { return this.deviceCBox; }
/*     */ 
/*     */ 
/*     */   
/*  87 */   public ComboBox getPort() { return this.deviceCBox; }
/*     */ 
/*     */   
/*     */   public void setLabelText(String labelName, String str) {
/*  91 */     switch (labelName) {
/*     */       case "deviceLabel":
/*  93 */         this.deviceLabel.setText(str);
/*     */         break;
/*     */       case "portLabel":
/*  96 */         this.portLabel.setText(str);
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setHeight(String name, Double value) {
/* 102 */     switch (name) {
/*     */       case "deviceLabel":
/* 104 */         this.deviceLabel.setPrefHeight(value.doubleValue());
/*     */         break;
/*     */       case "portLabel":
/* 107 */         this.portLabel.setPrefHeight(value.doubleValue());
/*     */         break;
/*     */       case "deviceCBox":
/* 110 */         this.deviceCBox.setPrefHeight(value.doubleValue());
/*     */         break;
/*     */       case "portCBox":
/* 113 */         this.portCBox.setPrefHeight(value.doubleValue());
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setWidth(String name, Double value) {
/* 119 */     switch (name) {
/*     */       case "deviceLabel":
/* 121 */         this.deviceLabel.setPrefWidth(value.doubleValue());
/*     */         break;
/*     */       case "portLabel":
/* 124 */         this.portLabel.setPrefWidth(value.doubleValue());
/*     */         break;
/*     */       case "deviceCBox":
/* 127 */         this.deviceCBox.setPrefWidth(value.doubleValue());
/*     */         break;
/*     */       case "portCBox":
/* 130 */         this.portCBox.setPrefWidth(value.doubleValue());
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setLayoutXPosition(String name, Double value) {
/* 136 */     switch (name) {
/*     */       case "deviceLabel":
/* 138 */         this.deviceLabel.setLayoutX(value.doubleValue());
/*     */         break;
/*     */       case "portLabel":
/* 141 */         this.portLabel.setLayoutX(value.doubleValue());
/*     */         break;
/*     */       case "deviceCBox":
/* 144 */         this.deviceCBox.setLayoutX(value.doubleValue());
/*     */         break;
/*     */       case "portCBox":
/* 147 */         this.portCBox.setLayoutX(value.doubleValue());
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void displayConfigs(Boolean comm) {
/* 153 */     this.portLabel.setVisible(comm.booleanValue());
/* 154 */     this.portCBox.setVisible(comm.booleanValue());
/*     */   }
/*     */   
/*     */   public void setDevice(String params) {
/* 158 */     StringParser p = new StringParser(params);
/* 159 */     String sparam = unifySerialInterface(p.nextToken(':'));
/* 160 */     this.deviceCBox.getSelectionModel().select(sparam);
/* 161 */     switch (this.deviceCBox.getSelectionModel().getSelectedItem().toString().toLowerCase()) {
/*     */       case "screen":
/*     */       case "not defined":
/*     */         break;
/*     */       default:
/* 166 */         this.portCBox.getSelectionModel().select(p.nextToken(',')); break;
/*     */     } 
/* 168 */     this.dirty.setValue(Boolean.valueOf(false));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 173 */   private String unifySerialInterface(String sparam) { return "rxtx".equals(sparam) ? "serial" : sparam; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDeviceParameters(ObservableList devices, ObservableList ports) {
/* 179 */     this.deviceCBox.setItems(devices);
/* 180 */     this.portCBox.setItems(ports);
/* 181 */     this.deviceCBox.getSelectionModel().selectFirst();
/* 182 */     this.dirty.set(false);
/*     */   }
/*     */   
/*     */   public String getDeviceParams() {
/* 186 */     String device = this.deviceCBox.getSelectionModel().getSelectedItem().toString();
/*     */     
/* 188 */     switch (device) {
/*     */       case "Not defined":
/*     */       case "screen":
/* 191 */         return device;
/*     */     } 
/* 193 */     StringBuilder tmp = new StringBuilder();
/* 194 */     tmp.append(device);
/* 195 */     tmp.append(":");
/* 196 */     tmp.append(this.portCBox.getSelectionModel().getSelectedItem().toString());
/* 197 */     return tmp.toString();
/*     */   }
/*     */ }
