package anass.springboot.controller

import anass.springboot.dao.ProductRepository
import anass.springboot.data.Product
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.lang.Exception

import java.nio.file.Files
import java.nio.file.Paths

@RestController
class MyRestController(private val productRepository: ProductRepository) {
    @GetMapping(path = ["/photoProduct/{id}"], produces = [MediaType.IMAGE_PNG_VALUE])
    @Throws(
        Exception::class
    )
    fun getPhoto(@PathVariable("id") id: Long): ByteArray {
        val p: Product = productRepository.findById(id).get()
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/ecom/products/" + p.photoName))
    }

    @PostMapping(path = ["/uploadPhoto/(id)"])
    @Throws(Exception::class)
    fun uploadPhoto(file: MultipartFile, @PathVariable id: Long) {
        val p: Product = productRepository.findById(id).get()
        p.photoName=file.originalFilename
        Files.write(
            Paths.get(System.getProperty("user.home") + "/ecom/products/" + p.photoName),
            file.bytes
        )
        productRepository.save(p)
    }
}
