package info.nightscout.androidaps.database.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import info.nightscout.androidaps.database.TABLE_BOLUS_CALCULATOR_RESULTS
import info.nightscout.androidaps.database.embedments.InterfaceIDs
import info.nightscout.androidaps.database.interfaces.DBEntry
import info.nightscout.androidaps.database.interfaces.DBEntryWithTime

@Entity(tableName = TABLE_BOLUS_CALCULATOR_RESULTS,
        foreignKeys = [ForeignKey(
                entity = BolusCalculatorResult::class,
                parentColumns = ["id"],
                childColumns = ["referenceID"])])
data class BolusCalculatorResult(
        @PrimaryKey(autoGenerate = true)
        override var id: Long = 0,
        override var version: Int = 0,
        override var lastModified: Long = -1,
        override var valid: Boolean = true,
        override var referenceID: Long = 0,
        @Embedded
        override var interfaceIDs: InterfaceIDs = InterfaceIDs(),
        override var timestamp: Long,
        override var utcOffset: Long,
        var targetBGLow: Double,
        var targetBGHigh: Double,
        var isf: Double,
        var ic: Double,
        var bolusIOB: Double,
        var bolusIOBUsed: Boolean,
        var basalIOB: Double,
        var basalIOBUsed: Boolean,
        var glucoseValue: Double,
        var glucoseUsed: Boolean,
        var glucoseDifference: Double,
        var glucoseCInsulin: Double,
        var glucoseTrend: Double,
        var trendUsed: Boolean,
        var trendInsulin: Double,
        var carbs: Double,
        var carbsUsed: Boolean,
        var carbsInsulin: Double,
        var otherCorrection: Double,
        var totalInsulin: Double
) : DBEntry, DBEntryWithTime