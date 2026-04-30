package co.bubotech.app_device_integrity

import com.google.android.gms.tasks.Task
import com.google.android.play.core.integrity.IntegrityTokenResponse
import com.google.android.play.core.integrity.IntegrityManager
import com.google.android.play.core.integrity.IntegrityManagerFactory
import com.google.android.play.core.integrity.IntegrityTokenRequest
import android.content.Context
import android.util.Base64

class AppDeviceIntegrity(
    context: Context,
    cloudProjectNumber: Long,
    nonce: String,                    // ← was hardcoded; now passed in
) {
    val integrityManager: IntegrityManager = IntegrityManagerFactory.create(context)

    val integrityTokenResponse: Task<IntegrityTokenResponse> =
        integrityManager.requestIntegrityToken(
            IntegrityTokenRequest.builder()
                .setNonce(nonce)                       // ← actually uses BE's nonce
                .setCloudProjectNumber(cloudProjectNumber)
                .build()
        )
}