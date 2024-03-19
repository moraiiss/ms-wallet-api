package br.com.wallet.infrastructure.repository

import br.com.wallet.infrastructure.repository.entity.SellerEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface SpringSellerRepository : JpaRepository<SellerEntity, UUID?> {
}