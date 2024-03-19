package br.com.wallet.application.interfaces.gateways

import br.com.wallet.domain.Seller
import java.util.Optional

interface SellerRepository {

    fun save(seller: Seller): Seller

    fun findById(id: String): Optional<Seller>

    fun findAll(): List<Seller>
}