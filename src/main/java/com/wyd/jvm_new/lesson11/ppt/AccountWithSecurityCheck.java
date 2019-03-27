package com.wyd.jvm_new.lesson11.ppt;
public class AccountWithSecurityCheck implements Account { 	
	 private  Account account; 
	 public AccountWithSecurityCheck (Account account) { 
		 this.account = account; 
	 } 
	 public void operation() { 
		 SecurityChecker.checkSecurity(); 
		 account.operation(); 
	 } 
 }