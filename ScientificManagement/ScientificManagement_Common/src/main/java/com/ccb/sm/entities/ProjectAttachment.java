package com.ccb.sm.entities;

import java.util.Date;

public class ProjectAttachment {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 所属ID
     */
    private String reference_id;
    /**
     * 文件名称
     */
    private String filename;
    /**
     * 文件大小
     */
    private Integer filesize;
    /**
     * 文件路径
     */
    private String fileurl;
    /**
     * 阶段
     */
    private String phase;
    /**
     * 备注
     */
    private String memo;
    /**
     * 关联类型
     */
    private String type;
    /**
     * 创建时间
     */
    private Date created_time;
    /**
     * 更新时间
     */
    private Date modified_time;
    /**
     * 删除状态
     */
    private Boolean deleted;
    /**
     * 删除时间
     */
    private Date deleted_time;

    public ProjectAttachment(Integer id, String reference_id, String filename, Integer filesize, String fileurl, String phase, String memo, String type, Date created_time, Date modified_time, Boolean deleted, Date deleted_time) {
        this.id = id;
        this.reference_id = reference_id;
        this.filename = filename;
        this.filesize = filesize;
        this.fileurl = fileurl;
        this.phase = phase;
        this.memo = memo;
        this.type = type;
        this.created_time = created_time;
        this.modified_time = modified_time;
        this.deleted = deleted;
        this.deleted_time = deleted_time;
    }

    public ProjectAttachment() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReference_id() {
        return reference_id;
    }

    public void setReference_id(String reference_id) {
        this.reference_id = reference_id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Integer getFilesize() {
        return filesize;
    }

    public void setFilesize(Integer filesize) {
        this.filesize = filesize;
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Date created_time) {
        this.created_time = created_time;
    }

    public Date getModified_time() {
        return modified_time;
    }

    public void setModified_time(Date modified_time) {
        this.modified_time = modified_time;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Date getDeleted_time() {
        return deleted_time;
    }

    public void setDeleted_time(Date deleted_time) {
        this.deleted_time = deleted_time;
    }
}