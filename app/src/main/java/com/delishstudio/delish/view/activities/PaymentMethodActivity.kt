package com.delishstudio.delish.view.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.delishstudio.delish.R
import com.delishstudio.delish.databinding.ActivityPaymentMethodBinding
import com.delishstudio.delish.model.PaymentMethod
import com.delishstudio.delish.model.User

class PaymentMethodActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityPaymentMethodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityPaymentMethodBinding.inflate(layoutInflater)
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        supportActionBar?.hide()
        setContentView(mBinding.root)

        updateButtons()
        onSetupButtons()
    }

    private fun updateButtons() {
        when(User.Main.payment) {
            PaymentMethod.BCA -> {
                mBinding.txtBcaDefault.text = "Default"
                mBinding.bcaBtSelected.setBackgroundResource(R.drawable.bt_selected)
            }
            PaymentMethod.BNI -> {
                mBinding.txtBniDefault.text = "Default"
                mBinding.bniBtSelected.setBackgroundResource(R.drawable.bt_selected)
            }
            PaymentMethod.GOPAY -> {
                mBinding.txtGopayDefault.text = "Default"
                mBinding.gopayBtSelected.setBackgroundResource(R.drawable.bt_selected)
            }
            PaymentMethod.LINKAJA -> {
                mBinding.txtLinkAjaDefault.text = "Default"
                mBinding.linkAjaBtSelected.setBackgroundResource(R.drawable.bt_selected)
            }
            PaymentMethod.MANDIRI -> {
                mBinding.txtMandiriDefault.text = "Default"
                mBinding.mandiriBtSelected.setBackgroundResource(R.drawable.bt_selected)
            }
            PaymentMethod.SHOPEEPAY -> {
                mBinding.txtShopeePayDefault.text = "Default"
                mBinding.shopeePayBtSelected.setBackgroundResource(R.drawable.bt_selected)
            }
            PaymentMethod.QRIS -> {
                mBinding.txtQrisDefault.text = "Default"
                mBinding.qrisBtSelected.setBackgroundResource(R.drawable.bt_selected)
            }
            else -> {
            }
        }
    }

    private fun onSetupButtons() {
        mBinding.btBack.setOnClickListener{
            User.Update()
            super.onBackPressed()
        }

        mBinding.bca.setOnClickListener{
            User.Main.payment = PaymentMethod.BCA
            updateButtons()
            mBinding.txtBniDefault.text = ""
            mBinding.txtGopayDefault.text = ""
            mBinding.txtQrisDefault.text = ""
            mBinding.txtLinkAjaDefault.text = ""
            mBinding.txtShopeePayDefault.text = ""
            mBinding.txtMandiriDefault.text = ""
            mBinding.bniBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.gopayBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.qrisBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.linkAjaBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.shopeePayBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.mandiriBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
        }
        mBinding.gopay.setOnClickListener{
            User.Main.payment = PaymentMethod.GOPAY
            updateButtons()
            mBinding.txtBniDefault.text = ""
            mBinding.txtQrisDefault.text = ""
            mBinding.txtLinkAjaDefault.text = ""
            mBinding.txtShopeePayDefault.text = ""
            mBinding.txtMandiriDefault.text = ""
            mBinding.txtBcaDefault.text = ""
            mBinding.bcaBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.bniBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.qrisBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.linkAjaBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.shopeePayBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.mandiriBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
        }
        mBinding.bni.setOnClickListener{
            User.Main.payment = PaymentMethod.BNI
            updateButtons()
            mBinding.txtGopayDefault.text = ""
            mBinding.txtQrisDefault.text = ""
            mBinding.txtLinkAjaDefault.text = ""
            mBinding.txtShopeePayDefault.text = ""
            mBinding.txtMandiriDefault.text = ""
            mBinding.txtBcaDefault.text = ""
            mBinding.gopayBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.bcaBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.qrisBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.linkAjaBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.shopeePayBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.mandiriBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
        }
        mBinding.qris.setOnClickListener{
            User.Main.payment = PaymentMethod.QRIS
            updateButtons()
            mBinding.txtBniDefault.text = ""
            mBinding.txtGopayDefault.text = ""
            mBinding.txtLinkAjaDefault.text = ""
            mBinding.txtShopeePayDefault.text = ""
            mBinding.txtMandiriDefault.text = ""
            mBinding.txtBcaDefault.text = ""
            mBinding.bniBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.gopayBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.bcaBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.linkAjaBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.shopeePayBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.mandiriBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
        }
        mBinding.linkAja.setOnClickListener{
            User.Main.payment = PaymentMethod.LINKAJA
            updateButtons()
            mBinding.txtBniDefault.text = ""
            mBinding.txtGopayDefault.text = ""
            mBinding.txtQrisDefault.text = ""
            mBinding.txtShopeePayDefault.text = ""
            mBinding.txtMandiriDefault.text = ""
            mBinding.txtBcaDefault.text = ""
            mBinding.qrisBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.bniBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.gopayBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.bcaBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.shopeePayBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.mandiriBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
        }
        mBinding.shopeepay.setOnClickListener{
            User.Main.payment = PaymentMethod.SHOPEEPAY
            updateButtons()
            mBinding.txtBniDefault.text = ""
            mBinding.txtGopayDefault.text = ""
            mBinding.txtQrisDefault.text = ""
            mBinding.txtLinkAjaDefault.text = ""
            mBinding.txtMandiriDefault.text = ""
            mBinding.txtBcaDefault.text = ""
            mBinding.linkAjaBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.qrisBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.bniBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.gopayBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.bcaBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.mandiriBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
        }
        mBinding.mandiri.setOnClickListener{
            User.Main.payment = PaymentMethod.MANDIRI
            updateButtons()
            mBinding.txtBniDefault.text = ""
            mBinding.txtGopayDefault.text = ""
            mBinding.txtQrisDefault.text = ""
            mBinding.txtLinkAjaDefault.text = ""
            mBinding.txtShopeePayDefault.text = ""
            mBinding.txtBcaDefault.text = ""
            mBinding.shopeePayBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.linkAjaBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.qrisBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.bniBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.gopayBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
            mBinding.bcaBtSelected.setBackgroundResource(R.drawable.bt_not_selected)
        }
    }
}
