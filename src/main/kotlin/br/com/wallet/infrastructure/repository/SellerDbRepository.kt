package br.com.wallet.infrastructure.repository

import br.com.wallet.application.interfaces.gateways.SellerRepository
import br.com.wallet.domain.Seller
import br.com.wallet.infrastructure.repository.entity.SellerEntity
import java.util.*

class SellerDbRepository (val repository: SpringSellerRepository)  {

//    override fun findAll(): List<Seller> {
//        val entities: List<SellerEntity> = repository.findAll()
//
//        return entities
//            .map(SellerEntity::toSeller)
//            .toList()
//    }

//    override fun save(seller: Seller): Seller {
//        val entity = SellerEntity(seller)
//
//        return repository.save(entity)
//            .toSeller()
//    }

//    override fun findById(id: UUID): Optional<Seller> {
//        val entity = repository.findById(id)
//
//        return entity
//            .map(SellerEntity::toSeller)
//    }
}