package com.demo.model;

public class Patient {
	 private int id;
	 private String name;
	 private String email;
	 private String description;
	 
	 public Patient() {
	  super();
	 }

	 public Patient(int id, String name, String email, String description) {
	  super();
	  this.id = id;
	  this.name = name;
	  this.email = email;
	  this.description = description;
	 }

	 public int getId() {
	  return id;
	 }

	 public void setId(int id) {
	  this.id = id;
	 }

	 public String getName() {
	  return name;
	 }

	 public void setName(String name) {
	  this.name = name;
	 }

	 public String getEmail() {
	  return email;
	 }

	 public void setEmail(String email) {
	  this.email = email;
	 }

	 public String getDescription() {
	  return description;
	 }

	 public void setDescription(String description) {
	  this.description = description;
	 }
	}