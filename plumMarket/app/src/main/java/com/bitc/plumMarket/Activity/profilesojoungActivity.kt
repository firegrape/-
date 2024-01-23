package com.bitc.plumMarket.Activity

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

import com.bitc.plumMarket.R
import com.bitc.plumMarket.databinding.ActivityProfilesojoungBinding


class profilesojoungActivity : AppCompatActivity() {

    lateinit var binding: ActivityProfilesojoungBinding
//    lateinit var filePath: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilesojoungBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //          뒤로 가기 버튼
        binding.btnBack.setOnClickListener {
            intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

//      완료 버튼 클릭스 프로필 페이지로 이동 버튼
        binding.btnMypageProfile.setOnClickListener {
            intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        val requestGalleryLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            try {
                result.data?.data?.let { fileUri ->
                    val calRatio = calculateInSampleSize(
                        fileUri,
                        resources.getDimensionPixelSize(R.dimen.imgSize),
                        resources.getDimensionPixelSize(R.dimen.imgSize),
                    )

                    val options = BitmapFactory.Options()
                    options.inSampleSize = calRatio

                    var inputStream = contentResolver.openInputStream(fileUri)
                    val bitmap = BitmapFactory.decodeStream(inputStream, null, options)
                    inputStream?.close()

                    bitmap?.let {
                        binding.profilePicture.setImageBitmap(bitmap)
                    } ?: Log.d("nch-provider", "이미지 없음")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        binding.btnPicher.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.type = "image/*"
            requestGalleryLauncher.launch(intent)
        }
    }

    private fun calculateInSampleSize(fileUri: Uri, reqWidth: Int, reqHeight: Int): Int {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true

        try {
            var inputStream = contentResolver.openInputStream(fileUri)
            BitmapFactory.decodeStream(inputStream, null, options)
            inputStream?.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        val (height: Int, width: Int) = options.run {
            outHeight to outWidth
        }
        var inSampleSize = 1

        if (height > reqHeight || width > reqWidth) {
            val halfHeight: Int = height / 2
            val halfWidth: Int = width / 2

            while (halfHeight / inSampleSize >= reqHeight && halfWidth / inSampleSize >= reqWidth) {
                inSampleSize *= 2
            }
        }
        return inSampleSize

    }

}
