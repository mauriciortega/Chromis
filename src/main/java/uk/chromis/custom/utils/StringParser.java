/*    */ package uk.chromis.custom.utils;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class StringParser
/*    */ {
/*    */   private int currentPosition;
/*    */   private int maxPosition;
/*    */   private String str;
/*    */   
/*    */   public StringParser(String str) {
/* 12 */     this.str = str;
/* 13 */     this.currentPosition = 0;
/* 14 */     this.maxPosition = (str == null) ? 0 : str.length();
/*    */   }
/*    */   
/*    */   public String nextToken(char c) {
/* 18 */     if (this.currentPosition < this.maxPosition) {
/* 19 */       int start = this.currentPosition;
/* 20 */       while (this.currentPosition < this.maxPosition && c != this.str.charAt(this.currentPosition)) {
/* 21 */         this.currentPosition++;
/*    */       }
/* 23 */       if (this.currentPosition < this.maxPosition) {
/* 24 */         return this.str.substring(start, this.currentPosition++);
/*    */       }
/* 26 */       return this.str.substring(start);
/*    */     } 
/*    */     
/* 29 */     return "";
/*    */   }
/*    */ }


/* Location:              /Users/mauricio/dev/Chromis/lib/ChromisCtrls-v1.1.jar!/uk/chromis/custom/utils/StringParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */