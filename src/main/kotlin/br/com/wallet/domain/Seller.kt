package br.com.wallet.domain

import br.com.wallet.application.dto.SellerDTO
import java.util.UUID

data class Seller (
    val id: UUID?,
    val sellerDocument: String?,
    val name: String?,
    val email: String?,
    val password: String?
) {
    fun fromSellerDto(sellerDto: SellerDTO) = Seller(
        null,
        sellerDto.sellerDocument,
        sellerDto.name,
        sellerDto.email,
        sellerDto.password
    )
}
