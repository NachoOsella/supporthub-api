package com.supporthub.api.attachments.repository;

import com.supporthub.api.attachments.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
}
