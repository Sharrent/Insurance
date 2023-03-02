package my.edu.tarc.insurance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import my.edu.tarc.insurance.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //to refer to all ui elements
        binding.buttonCalculate.setOnClickListener {
            //local varaible to store premium
            //val will not change
            //var will change
            var basic: Int = 0
            var extra: Int = 0
            var total: Int = 0

            val age = binding.spinnerAge.selectedItemPosition
            if (age == 0) { //less than 17
                basic = 60
            } else if (age == 1) {
                basic = 70

            } else if (age == 2) {
                basic = 90
            } else if (age == 3) {
                basic = 120
            } else {
                basic = 150
            }
            val gender = binding.radioGroupGender.checkedRadioButtonId
            if (gender == binding.radioButtonMale.id) {
                // Calc extra premium for male
                if (age == 1) { //less than 17
                    extra = 50
                } else if (age == 2) {
                    extra = 100

                } else if (age == 3) {
                    extra = 150
                } else if (age == 4 || age == 5) {
                    extra = 200
                }
            }

            val smoker = binding.checkBoxSmoker.isChecked
            if (smoker) {
                // Calc extra premium for smoker
                if (age == 1) { //less than 17
                    extra += 100
                } else if (age == 2) {
                    extra += 150

                } else if (age == 3) {
                    extra += 200
                } else if (age == 4) {
                    extra += 250
                } else if (age == 5) {
                    extra += 300
                }
            }
            total = basic + extra
            val premium: Premium = Premium(basic, extra, total)
            //for display value purpose
            binding.myPremium = premium
        }
        binding.buttonReset.setOnClickListener {
            val premium: Premium = Premium()
            //for display value purpose
            binding.myPremium = premium
            binding.spinnerAge.setSelection(0)
            binding.radioGroupGender.clearCheck()
            binding.checkBoxSmoker.toggle()

        }

    }
}