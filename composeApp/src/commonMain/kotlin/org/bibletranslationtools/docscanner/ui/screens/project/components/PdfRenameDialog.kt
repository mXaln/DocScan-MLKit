package org.bibletranslationtools.docscanner.ui.screens.project.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import docscanner.composeapp.generated.resources.Res
import docscanner.composeapp.generated.resources.cancel
import docscanner.composeapp.generated.resources.ok
import docscanner.composeapp.generated.resources.pdf_name
import docscanner.composeapp.generated.resources.rename_pdf
import org.jetbrains.compose.resources.stringResource

@Composable
fun PdfRenameDialog(
    name: String,
    onRename: (String) -> Unit,
    onDismissRequest: () -> Unit,
) {
    var newNameText by remember(name) {
        mutableStateOf(name)
    }

    Dialog(onDismissRequest = onDismissRequest) {
        Surface(
            shape = MaterialTheme.shapes.medium,
            color = MaterialTheme.colorScheme.surface
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    stringResource(Res.string.rename_pdf),
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = newNameText,
                    onValueChange = { newText -> newNameText = newText },

                    label = { Text(stringResource(Res.string.pdf_name)) })
                Spacer(modifier = Modifier.height(9.dp))
                Row {
                    Spacer(Modifier.width(0.dp))

                    Button(onClick = onDismissRequest) {
                        Text(stringResource(Res.string.cancel))
                    }

                    Spacer(Modifier.width(6.dp))

                    Button(onClick = {
                        onRename(newNameText)
                        onDismissRequest()
                    }) {
                        Text(stringResource(Res.string.ok))
                    }
                }
            }
        }
    }
}