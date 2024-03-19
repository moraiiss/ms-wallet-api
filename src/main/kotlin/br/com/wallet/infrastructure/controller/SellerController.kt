package br.com.wallet.infrastructure.controller

import br.com.wallet.domain.Seller
import br.com.wallet.infrastructure.commons.MediaType
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

//@RestController
//@RequestMapping("/v1/sellers")
//@Tag(name = "Sellers", description = "Endpoints for managing sellers")
//class SellerController () {
//
//    @GetMapping(
//        produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML]
//    )
//    @Operation(summary = "List all sellers", description = "Returns all sellers found")
//    fun list(): ResponseEntity<List<Seller>> = ResponseEntity.ok(useCases.list())
//}