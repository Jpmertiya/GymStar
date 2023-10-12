package com.Gym.Star.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Gym.Star.Entity.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {
	public Donation findByOrderId(String id);
}
