package com.skillswap.skillswap.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "swap_requests")
public class SwapRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "requester_id", nullable = false)
	private User requester;

	@ManyToOne
	@JoinColumn(name = "receiver_id", nullable = false)
	private User receiver;

	@ManyToOne
	@JoinColumn(name = "offered_skill_id", nullable = false)
	private Skill offeredSkill;

	@ManyToOne
	@JoinColumn(name = "requested_skill_id", nullable = false)
	private Skill requestedSkill;

	@Enumerated(EnumType.STRING)
	private SwapStatus status;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	public SwapRequest() {
	}

	@PrePersist
	public void prePersist() {
		this.createdAt = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getRequester() {
		return requester;
	}

	public void setRequester(User requester) {
		this.requester = requester;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public Skill getOfferedSkill() {
		return offeredSkill;
	}

	public void setOfferedSkill(Skill offeredSkill) {
		this.offeredSkill = offeredSkill;
	}

	public Skill getRequestedSkill() {
		return requestedSkill;
	}

	public void setRequestedSkill(Skill requestedSkill) {
		this.requestedSkill = requestedSkill;
	}

	public SwapStatus getStatus() {
		return status;
	}

	public void setStatus(SwapStatus status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

}