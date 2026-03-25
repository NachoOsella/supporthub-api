package com.supporthub.api.auditlog.repository;

import com.supporthub.api.auditlog.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
}
