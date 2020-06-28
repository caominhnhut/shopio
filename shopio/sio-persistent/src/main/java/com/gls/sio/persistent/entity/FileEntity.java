package com.gls.sio.persistent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "file")
@SequenceGenerator(name = "file_seq", initialValue = 1)
public class FileEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "file_seq")
    private Long id;

    @Column(name = "file_name", unique = true)
    private String filename;

    @Column(name = "file_type")
    private String fileType;

    @Transient
    private byte[] data;

    @Column(name = "file_download_uri")
    private String fileDownloadUri;
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
    private ProductEntity product;

    public FileEntity()
    {

    }

    public FileEntity(String filename, String fileType, byte[] data)
    {
        this.filename = filename;
        this.fileType = fileType;
        this.data = data;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getFilename()
    {
        return filename;
    }

    public void setFilename(String filename)
    {
        this.filename = filename;
    }

    public String getFileType()
    {
        return fileType;
    }

    public void setFileType(String fileType)
    {
        this.fileType = fileType;
    }

    public byte[] getData()
    {
        return data;
    }

    public void setData(byte[] data)
    {
        this.data = data;
    }

    public String getFileDownloadUri()
    {
        return fileDownloadUri;
    }

    public void setFileDownloadUri(String fileDownloadUri)
    {
        this.fileDownloadUri = fileDownloadUri;
    }

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
		product.getFiles().add(this);
	}
}