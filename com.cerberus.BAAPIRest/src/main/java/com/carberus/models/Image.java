package com.carberus.models;

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
	private Integer ImageId;
	
	@Column(name = "Description" )	
	private String Description;
	
	@Column(name = "FileName" )	
	private String FileName;
	
	@Column(name = "Data" )	
	private Byte[] Data;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
	public Integer getImageId() {
		return ImageId;
	}

	public void setImageId(Integer imageId) {
		ImageId = imageId;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

	public Byte[] getData() {
		return Data;
	}

	public void setData(Byte[] data) {
		Data = data;
	}

	public Image() {
	}

	public Image(Integer imageId, String description, String fileName, Byte[] data) {
		ImageId = imageId;
		Description = description;
		FileName = fileName;
		Data = data;
	}

	@Override
	public String toString() {
		return "Image [ImageId=" + ImageId + ", Description=" + Description + ", FileName=" + FileName + "]";
	}
	
	
}
