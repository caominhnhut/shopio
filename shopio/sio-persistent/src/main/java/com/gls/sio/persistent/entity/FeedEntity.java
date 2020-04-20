package com.gls.sio.persistent.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "feed")
@SequenceGenerator(name = "feed_seq", initialValue = 1)
public class FeedEntity extends BaseTimestamp
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feed_seq")
    private Long id;

    @Column(name = "description", nullable = false)
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String description;

    @Column(name = "image")
    @Lob
    private byte[] image;

    @Column(name = "num_of_like")
    private Long numOfLike = 0L;

    @Column(name = "num_of_sharing")
    private Long numOfSharing = 0L;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private UserEntity owner;

    @OneToMany(mappedBy = "feed", cascade = CascadeType.REMOVE)
//    @Where(clause = "id<=2")
    private List<CommentEntity> comments = new ArrayList<>();

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Long getNumOfLike()
    {
        return numOfLike;
    }

    public void setNumOfLike(Long numOfLike)
    {
        this.numOfLike = numOfLike;
    }

    public Long getNumOfSharing()
    {
        return numOfSharing;
    }

    public void setNumOfSharing(Long numOfSharing)
    {
        this.numOfSharing = numOfSharing;
    }

    public UserEntity getOwner()
    {
        return owner;
    }

    public void setOwner(UserEntity owner)
    {
        this.owner = owner;
    }

    public List<CommentEntity> getComments()
    {
        return comments;
    }

    public byte[] getImage()
    {
        return image;
    }

    public void setImage(byte[] image)
    {
        this.image = image;
    }

    public void setComments(List<CommentEntity> comments)
    {
        this.comments = comments;
    }
}
