package anass.springboot.entities

import anass.springboot.data.Product
import org.springframework.data.rest.core.config.Projection


@Projection(name = "P1", types = [Product::class])
interface ProductProjection {
    var currentPrice: Double
    var name: String?
}
