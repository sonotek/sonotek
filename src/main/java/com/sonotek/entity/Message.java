/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sonotek.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Oguzhan
 */
@Entity
@Table(name = "message")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m")
    , @NamedQuery(name = "Message.findByIdmessage", query = "SELECT m FROM Message m WHERE m.idmessage = :idmessage")
    , @NamedQuery(name = "Message.findByMessage", query = "SELECT m FROM Message m WHERE m.message = :message")})
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmessage")
    private Integer idmessage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "message")
    private String message;
    @JoinColumn(name = "sendMessageUserId", referencedColumnName = "idUser")
    @ManyToOne(optional = false)
    private User sendMessageUserId;
    @JoinColumn(name = "receiveMessageUserId", referencedColumnName = "idUser")
    @ManyToOne(optional = false)
    private User receiveMessageUserId;

    public Message() {
    }

    public Message(Integer idmessage) {
        this.idmessage = idmessage;
    }

    public Message(Integer idmessage, String message) {
        this.idmessage = idmessage;
        this.message = message;
    }

    public Integer getIdmessage() {
        return idmessage;
    }

    public void setIdmessage(Integer idmessage) {
        this.idmessage = idmessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getSendMessageUserId() {
        return sendMessageUserId;
    }

    public void setSendMessageUserId(User sendMessageUserId) {
        this.sendMessageUserId = sendMessageUserId;
    }

    public User getReceiveMessageUserId() {
        return receiveMessageUserId;
    }

    public void setReceiveMessageUserId(User receiveMessageUserId) {
        this.receiveMessageUserId = receiveMessageUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmessage != null ? idmessage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Message)) {
            return false;
        }
        Message other = (Message) object;
        if ((this.idmessage == null && other.idmessage != null) || (this.idmessage != null && !this.idmessage.equals(other.idmessage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sonotek.entity.Message[ idmessage=" + idmessage + " ]";
    }
    
}
