package anass.springboot.data

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import lombok.ToString
import java.io.Serializable
import javax.persistence.*


@Entity
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Data
class Product : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?=null
    var name: String? = null
    var description: String? = null
    var currentPrice: Double = 0.0

    var promotion:Boolean = false
    var selected:Boolean = false
    var available:Boolean = false
    var photoName: String? = null
        set(value) {
            field = value
        }
    @ManyToOne
    var category: Category?

    constructor(name: String?,  currentPrice: Double,available: Boolean, promotion: Boolean, selected: Boolean,category: Category?, photoName: String?) {
        this.name = name
        this.currentPrice = currentPrice
        this.available = available
        this.promotion = promotion
        this.selected = selected
        this.category = category
        this.photoName = photoName

    }



}