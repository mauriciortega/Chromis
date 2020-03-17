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
/*     */ public class ScannerConfig
/*     */   extends HBox
/*     */ {
/*     */   @FXML
/*     */   private Label deviceLabel;
/*     */   @FXML
/*     */   private Label portLabel;
/*     */   @FXML
/*     */   private ComboBox scannerCBox;
/*     */   @FXML
/*     */   private ComboBox portCBox;
/*     */   @FXML
/*     */   private Pane optionsPane;
/*  37 */   public BooleanProperty dirty = new SimpleBooleanProperty(false);
/*     */ 
/*     */ 
/*     */   
/*     */   public ScannerConfig() {
/*  42 */     FXMLLoader loader = new FXMLLoader(getClass().getResource("ScannerConfig.fxml"));
/*  43 */     loader.setRoot(this);
/*  44 */     loader.setController(this);
/*     */     try {
/*  46 */       loader.load();
/*  47 */       init();
/*  48 */     } catch (IOException ex) {
/*  49 */       Logger.getLogger(ScannerConfig.class.getName()).log(Level.SEVERE, null, ex);
/*  50 */       throw new RuntimeException(ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void init() {
/*  56 */     this.scannerCBox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
/*  57 */           this.dirty.setValue(Boolean.valueOf(true));
/*  58 */           switch (this.scannerCBox.getSelectionModel().getSelectedItem().toString().toLowerCase()) {
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
/*     */     
/*  72 */     this.portCBox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> this.dirty.setValue(Boolean.valueOf(true)));
/*     */   }
/*     */ 
/*     */   
/*  76 */   public ComboBox getScanner() { return this.scannerCBox; }
/*     */ 
/*     */ 
/*     */   
/*  80 */   public ComboBox getPort() { return this.portCBox; }
/*     */ 
/*     */ 
/*     */   
/*  84 */   public Boolean isDirty() { return this.dirty.getValue(); }
/*     */ 
/*     */ 
/*     */   
/*  88 */   public void setDirty(Boolean dirty) { this.dirty.setValue(dirty); }
/*     */ 
/*     */   
/*     */   private void displayConfigs(Boolean comm) {
/*  92 */     this.portLabel.setVisible(comm.booleanValue());
/*  93 */     this.portCBox.setVisible(comm.booleanValue());
/*     */   }
/*     */   
/*     */   public void setLabelText(String labelName, String str) {
/*  97 */     switch (labelName) {
/*     */       case "deviceLabel":
/*  99 */         this.deviceLabel.setText(str);
/*     */         break;
/*     */       case "portLabel":
/* 102 */         this.portLabel.setText(str);
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setHeight(String name, Double value) {
/* 108 */     switch (name) {
/*     */       case "deviceLabel":
/* 110 */         this.deviceLabel.setPrefHeight(value.doubleValue());
/*     */         break;
/*     */       case "portLabel":
/* 113 */         this.portLabel.setPrefHeight(value.doubleValue());
/*     */         break;
/*     */       case "scannerCBox":
/* 116 */         this.scannerCBox.setPrefHeight(value.doubleValue());
/*     */         break;
/*     */       case "portCBox":
/* 119 */         this.portCBox.setPrefHeight(value.doubleValue());
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setWidth(String name, Double value) {
/* 125 */     switch (name) {
/*     */       case "deviceLabel":
/* 127 */         this.deviceLabel.setPrefWidth(value.doubleValue());
/*     */         break;
/*     */       case "portLabel":
/* 130 */         this.portLabel.setPrefWidth(value.doubleValue());
/*     */         break;
/*     */       case "scannerCBox":
/* 133 */         this.scannerCBox.setPrefWidth(value.doubleValue());
/*     */         break;
/*     */       case "portCBox":
/* 136 */         this.portCBox.setPrefWidth(value.doubleValue());
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setLayoutXPosition(String name, Double value) {
/* 142 */     switch (name) {
/*     */       case "deviceLabel":
/* 144 */         this.deviceLabel.setLayoutX(value.doubleValue());
/*     */         break;
/*     */       case "portLabel":
/* 147 */         this.portLabel.setLayoutX(value.doubleValue());
/*     */         break;
/*     */       case "scannerCBox":
/* 150 */         this.scannerCBox.setLayoutX(value.doubleValue());
/*     */         break;
/*     */       case "portCBox":
/* 153 */         this.portCBox.setLayoutX(value.doubleValue());
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setScanner(String params) {
/* 159 */     StringParser p = new StringParser(params);
/* 160 */     String sparam = unifySerialInterface(p.nextToken(':'));
/* 161 */     this.scannerCBox.getSelectionModel().select(sparam);
/* 162 */     switch (this.scannerCBox.getSelectionModel().getSelectedItem().toString().toLowerCase()) {
/*     */ 
/*     */ 
/*     */       
/*     */       case "scanpal2":
/* 167 */         this.portCBox.getSelectionModel().select(p.nextToken(','));
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 175 */   private String unifySerialInterface(String sparam) { return "rxtx".equals(sparam) ? "serial" : sparam; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setScannerParameters(ObservableList devices, ObservableList ports) {
/* 182 */     this.portCBox.setItems(ports);
/* 183 */     this.scannerCBox.setItems(devices);
/* 184 */     this.scannerCBox.getSelectionModel().selectFirst();
/*     */     
/* 186 */     this.dirty.setValue(Boolean.valueOf(false));
/*     */   }
/*     */   
/*     */   public String getScannerParams() {
/* 190 */     String scanner = this.scannerCBox.getSelectionModel().getSelectedItem().toString();
/*     */     
/* 192 */     switch (scanner) {
/*     */       case "Not defined":
/* 194 */         return scanner;
/*     */     } 
/* 196 */     StringBuilder tmp = new StringBuilder();
/* 197 */     tmp.append(scanner);
/* 198 */     tmp.append(":");
/* 199 */     tmp.append(this.portCBox.getSelectionModel().getSelectedItem().toString());
/* 200 */     return tmp.toString();
/*     */   }
/*     */ }


/* Location:              /Users/mauricio/dev/Chromis/lib/ChromisCtrls-v1.1.jar!/uk/chromis/custom/controls/ScannerConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
