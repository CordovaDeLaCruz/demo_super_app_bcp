package com.demo.share.libs.presentation.components.alert

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun AlertDialog(
    isShowDialog: Boolean = false,
    state: String = AlertDialogViewState.Error.state,
    title: String? = "",
    text: String? = "",
    onClickClose: (() -> Unit),
    textPrimary: String? = "",
    onClickPrimary: (() -> Unit)? = null,
    textSecondary: String? = "",
    onClickSecondary: (() -> Unit)? = null,
    buttonClose: Boolean? = true
) {
    val scrollState = rememberScrollState()

    if (isShowDialog) {
        Dialog(
            properties = DialogProperties(usePlatformDefaultWidth = false),
            onDismissRequest = { }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
            ) {
                if (buttonClose == true){
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFFFFFFF))
                            .clickable {
                                onClickClose()
                            }
                            .align(Alignment.End),
                        contentAlignment = Alignment.Center
                    ) {

                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = null
                        )
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFFFFFFFF))
                        .verticalScroll(scrollState),
                ) {

                    Spacer(modifier = Modifier.height(40.dp))

                    if (!title.isNullOrEmpty()) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp),
                            text = title,
                            textAlign = TextAlign.Center
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))

                    if (!text.isNullOrEmpty()) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 30.dp),
                            text = text,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        if (!textSecondary.isNullOrEmpty() || state == AlertDialogViewState.Confirm.state) {
                            Button(
                                onClick = {
                                    if (onClickSecondary != null) {
                                        onClickSecondary()
                                    }
                                }
                            )
                            {
                                Text(
                                    text = if (textSecondary.isNullOrEmpty()) "Cancelar" else textSecondary
                                )
                            }
                        }

                        Button(
                            onClick = {
                                if (onClickPrimary != null) {
                                    onClickPrimary()
                                }
                            }
                        )
                        {
                            Text(
                                text = if (!textPrimary.isNullOrEmpty()) textPrimary else "Aceptar"
                            )
                        }

                    }
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlertDialogPreview(){
    AlertDialog(
        isShowDialog = true,
        text = "Test122",
        onClickClose = {},

        )
}