package com.cerberus.models;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Images")
public class Image implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name = "ImageId" )
	private Integer imageId;
	
	@Column(name = "Description" )
	private String description;
	
	@Column(name = "FileName" )
	private String fileName;
	
	@Column(name = "Data" )
	private byte[] data;

	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Image() {
	}

	public Image(Integer imageId, String description, String fileName, byte[] data) {
		this.imageId = imageId;
		this.description = description;
		this.fileName = fileName;
		this.data = data;
	}

	@Override
	public String toString() {
		return "Image [imageId=" + imageId + ", description=" + description + ", fileName=" + fileName + "]";
	}
	
	
}
