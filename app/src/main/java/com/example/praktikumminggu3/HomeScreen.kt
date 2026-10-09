package com.example.praktikumminggu3

import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun sp(id: Int) = dimensionResource(id).value.sp

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(R.color.background_screen))
            .padding(top = dimensionResource(R.dimen.header_top_padding)),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = stringResource(R.string.title_main),
            color = colorResource(R.color.text_primary),
            fontSize = sp(R.dimen.text_title),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.title_campus),
            color = colorResource(R.color.text_primary),
            fontSize = sp(R.dimen.text_subtitle),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = dimensionResource(R.dimen.header_bottom_padding))
        )
        MahasiswaCard(
            nama = R.string.name_bambang,
            alamat = R.string.address_bambang,
            warnaKartu = R.color.card_gray,
            warnaAlamat = R.color.text_address_yellow,
            fontNama = FontFamily.Cursive,
            beratNama = FontWeight.Normal
        )
        MahasiswaCard(
            nama = R.string.name_gibran,
            alamat = R.string.address_gibran,
            warnaKartu = R.color.card_purple,
            warnaAlamat = R.color.text_address_yellow,
            telepon = R.string.phone_number
        )
        MahasiswaCard(
            nama = R.string.name_zhilal,
            alamat = R.string.address_zhilal,
            warnaKartu = R.color.card_blue,
            warnaAlamat = R.color.text_address_white,
            telepon = R.string.phone_number
        )
        MahasiswaCard(
            nama = R.string.name_alfian,
            alamat = R.string.address_alfian,
            warnaKartu = R.color.card_green,
            warnaAlamat = R.color.text_address_white,
            telepon = R.string.phone_number
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Text(
                text = stringResource(R.string.footer_copyright),
                color = colorResource(R.color.text_primary),
                fontSize = sp(R.dimen.text_footer),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = dimensionResource(R.dimen.footer_padding))
            )
        }
    }
}
@Composable
fun MahasiswaCard(
    @StringRes nama: Int,
    @StringRes alamat: Int,
    @ColorRes warnaKartu: Int,
    @ColorRes warnaAlamat: Int,
    @StringRes telepon: Int? = null,
    fontNama: FontFamily? = null,
    beratNama: FontWeight = FontWeight.Bold
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = dimensionResource(R.dimen.card_spacing)),
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner)),
        colors = CardDefaults.cardColors(containerColor = colorResource(warnaKartu))
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = dimensionResource(R.dimen.card_padding_horizontal),
                vertical = dimensionResource(R.dimen.card_padding_vertical)
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Logo()
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = dimensionResource(R.dimen.text_gap_horizontal))
            ) {
                Text(
                    text = stringResource(nama),
                    color = colorResource(R.color.text_on_card),
                    fontFamily = fontNama,
                    fontWeight = beratNama,
                    fontSize = sp(R.dimen.text_name)
                )
                telepon?.let {
                    Text(
                        text = stringResource(it),
                        color = colorResource(R.color.text_phone),
                        fontSize = sp(R.dimen.text_detail)
                    )
                }
                Text(
                    text = stringResource(alamat),
                    color = colorResource(warnaAlamat),
                    fontSize = sp(R.dimen.text_detail)
                )
            }
            Logo()
        }
    }
}

@Composable
fun Logo() = Image(
    painter = painterResource(R.drawable.logo_umy),
    contentDescription = stringResource(R.string.cd_logo),
    modifier = Modifier.size(dimensionResource(R.dimen.logo_size))
)

@Preview(showBackground = true)