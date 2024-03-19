package br.com.wallet.infrastructure.repository.entity

import br.com.wallet.domain.Seller
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "sellers")
data class SellerEntity(
    @Id @GeneratedValue(strategy = GenerationType.UUID) var id: UUID?,
    var name: String?,
    var email: String?,
    var password: String?,
    var sellerDocument: String?
) {
    constructor(
        seller: Seller
    ) : this(
        null,
        seller.name,
        seller.email,
        seller.password,
        seller.sellerDocument
    )

    fun toSeller(): Seller {
        return Seller(
            id,
            name,
            email,
            password,
            sellerDocument
        )
    }
}