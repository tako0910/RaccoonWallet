package wacode.yamada.yuki.nempaymentapp.rest.item

import wacode.yamada.yuki.nempaymentapp.rest.model.MosaicAppEntity
import wacode.yamada.yuki.nempaymentapp.rest.model.MosaicIdAppEntity
import java.io.Serializable
import java.text.NumberFormat

class SendMosaicItem(mosaicItem: MosaicItem, val amount: Double) : Serializable {
    private val name: String
    private val namespaceId: String
    private val quantity: String

    init {
        quantity = mosaicItem.getQuantity()
        name = mosaicItem.mosaic.mosaicId.name
        namespaceId = mosaicItem.mosaic.mosaicId.namespaceId
    }

    fun mosaicName() = name
    fun nameSpace() = namespaceId
    private fun getFullName() = "$namespaceId:$name"
    fun getFormattedAmount() = NumberFormat.getNumberInstance().format(amount) + " " + getFullName()

    companion object {
        fun createNEMXEMItem(amount: Double) = SendMosaicItem(MosaicItem(MosaicAppEntity(MosaicIdAppEntity("nem", "xem"), 0)), amount)
    }
}