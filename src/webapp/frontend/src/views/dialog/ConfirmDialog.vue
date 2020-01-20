<template>
  <div>
    <div>{{textConfirm}}</div>
    <br>
    <el-row>
      <el-col>
        <el-button type="primary" @click="confirm">Confirm</el-button>
        <el-button @click="cancel">Cancel</el-button>
      </el-col>
    </el-row>
  </div>
</template>

<script lang="ts">
/* eslint-disable */
import {  Component,  Vue, Prop} from 'vue-property-decorator';

@Component({})
export default class ConfirmDialog extends Vue {
  @Prop() textConfirm?: string;

  private mounted() {
    
  }

  private cancel() {
    this.$emit('cancel');
  }

  private confirm() {
    this.$emit('confirm');
  }

}
</script>

<style lang="scss" scoped>
</style>